package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.LifeLabel;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * ALIPAY API: alipay.open.public.life.label.batchquery response.
 *
 * @author auto create
 * @since 1.0, 2018-05-11 19:07:44
 */
public class AlipayOpenPublicLifeLabelBatchqueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 4595793818642929581L;

	/**
	 * 标签列表
	 */
	@ApiListField("labels")
	@ApiField("life_label")
	private List<LifeLabel> labels;

	public void setLabels(List<LifeLabel> labels) {
		this.labels = labels;
	}

	public List<LifeLabel> getLabels() {
		return this.labels;
	}

}
