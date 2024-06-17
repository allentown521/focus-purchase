package com.alipay.api.internal.parser.xml;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayConstants;
import com.alipay.api.AlipayRequest;
import com.alipay.api.AlipayResponse;
import com.alipay.api.Decryptor;
import com.alipay.api.ResponseParseItem;
import com.alipay.api.SignItem;
import com.alipay.api.internal.mapping.Converter;
import com.alipay.api.internal.util.StringUtils;
import com.alipay.api.internal.util.XmlUtils;

import org.w3c.dom.Element;

/**
 * JSON格式转换器。
 *
 * @author carver.gu
 * @since 1.0, Apr 11, 2010
 */
public class XmlConverter implements Converter {

    public <T extends AlipayResponse> T toResponse(String rsp, Class<T> clazz)
            throws AlipayApiException {
        Element root = XmlUtils.getRootElementFromString(rsp);
        return getModelFromXML(root, clazz);
    }

    private <T> T getModelFromXML(final Element element, Class<T> clazz) throws AlipayApiException {
        return null;

    }

    /**
     * @see com.alipay.api.internal.mapping.Converter#getSignItem(com.alipay.api.AlipayRequest, String)
     */
    public SignItem getSignItem(AlipayRequest<?> request, String responseBody)
            throws AlipayApiException {

        // 响应为空则直接返回
        if (StringUtils.isEmpty(responseBody)) {

            return null;
        }

        SignItem signItem = new SignItem();

        // 获取签名
        String sign = getSign(responseBody);
        signItem.setSign(sign);

        // 签名源串
        String signSourceData = getSignSourceData(request, responseBody);
        signItem.setSignSourceDate(signSourceData);

        return signItem;
    }

    /**
     * @param request
     * @param body
     * @return
     */
    private String getSignSourceData(AlipayRequest<?> request, String body) {

        // XML不同的节点
        String rootNode = request.getApiMethodName().replace('.', '_')
                + AlipayConstants.RESPONSE_SUFFIX;
        String errorRootNode = AlipayConstants.ERROR_RESPONSE;

        int indexOfRootNode = body.indexOf(rootNode);
        int indexOfErrorRoot = body.indexOf(errorRootNode);

        // 成功或者新版接口
        if (indexOfRootNode > 0) {

            return parseSignSourceData(body, rootNode, indexOfRootNode);
            // 老版本接口
        } else if (indexOfErrorRoot > 0) {

            return parseSignSourceData(body, errorRootNode, indexOfErrorRoot);
        } else {
            return null;
        }
    }

    /**
     * 获取签名
     *
     * @param body
     * @return
     */
    private String getSign(String body) {

        String signNodeName = "<" + AlipayConstants.SIGN + ">";
        String signEndNodeName = "</" + AlipayConstants.SIGN + ">";

        int indexOfSignNode = body.indexOf(signNodeName);
        int indexOfSignEndNode = body.indexOf(signEndNodeName);

        if (indexOfSignNode < 0 || indexOfSignEndNode < 0) {
            return null;
        }

        //  签名
        return body.substring(indexOfSignNode + signNodeName.length(), indexOfSignEndNode);
    }

    /**
     * 签名源串
     *
     * @param body
     * @param rootNode
     * @param indexOfRootNode
     * @return
     */
    private String parseSignSourceData(String body, String rootNode, int indexOfRootNode) {

        //  第一个字母+长度+>
        int signDataStartIndex = indexOfRootNode + rootNode.length() + 1;
        int indexOfSign = body.indexOf("<" + AlipayConstants.SIGN);

        if (indexOfSign < 0) {

            return null;
        }

        // 签名前减去
        int signDataEndIndex = indexOfSign;

        return body.substring(signDataStartIndex, signDataEndIndex);
    }

    public String decryptSourceData(AlipayRequest<?> request, String body, String format,
                                    Decryptor decryptor, String encryptType, String charset)
            throws AlipayApiException {

        ResponseParseItem respSignSourceData = getXMLSignSourceData(request, body);

        String bodyIndexContent = body.substring(0, respSignSourceData.getStartIndex());
        String bodyEndContent = body.substring(respSignSourceData.getEndIndex());

        return bodyIndexContent
                + decryptor.decrypt(respSignSourceData.getEncryptContent(), encryptType, charset)
                + bodyEndContent;
    }

    /**
     * @param request
     * @param body
     * @return
     */
    private ResponseParseItem getXMLSignSourceData(AlipayRequest<?> request, String body) {

        // XML涓�������������
        String rootNode = request.getApiMethodName().replace('.', '_')
                + AlipayConstants.RESPONSE_SUFFIX;
        String errorRootNode = AlipayConstants.ERROR_RESPONSE;

        int indexOfRootNode = body.indexOf(rootNode);
        int indexOfErrorRoot = body.indexOf(errorRootNode);

        if (indexOfRootNode > 0) {

            return parseXMLSignSourceData(body, rootNode, indexOfRootNode);

        } else if (indexOfErrorRoot > 0) {

            return parseXMLSignSourceData(body, errorRootNode, indexOfErrorRoot);
        } else {
            return null;
        }
    }

    /**
     * 绛惧��婧�涓�
     *
     * @param body
     * @param rootNode
     * @param indexOfRootNode
     * @return
     */
    private ResponseParseItem parseXMLSignSourceData(String body, String rootNode,
                                                     int indexOfRootNode) {

        int signDataStartIndex = indexOfRootNode + rootNode.length() + 1;

        String xmlStartNode = "<" + AlipayConstants.RESPONSE_XML_ENCRYPT_NODE_NAME + ">";
        String xmlEndNode = "</" + AlipayConstants.RESPONSE_XML_ENCRYPT_NODE_NAME + ">";

        int indexOfSign = body.indexOf(xmlEndNode);

        if (indexOfSign < 0) {

            return new ResponseParseItem(0, 0, "");
        }

        int signDataEndIndex = indexOfSign + xmlEndNode.length();

        // 包含xml节点的
        String encryptBizContent = body.substring(signDataStartIndex, signDataEndIndex);

        String bizContent = encryptBizContent.substring(xmlStartNode.length(),
                encryptBizContent.length() - xmlEndNode.length());

        return new ResponseParseItem(signDataStartIndex, signDataEndIndex, bizContent);
    }

}
