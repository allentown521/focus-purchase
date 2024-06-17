package allen.town.focus_purchase.iap.util;

import com.android.billingclient.api.BillingClient;


public class IabResult {
    String mMessage;
    int mResponse;

    public IabResult(int code, String str) {
        this.mResponse = code;
        this.mMessage = str;
    }

    public int getResponse() {
        return this.mResponse;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public boolean isSuccess() {
        return this.mResponse == BillingClient.BillingResponseCode.OK;
    }

    public boolean isFailure() {
        return !isSuccess();
    }

    public String toString() {
        return "IabResult: " + getMessage();
    }
}
