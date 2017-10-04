package com.taotao.common.pojo;

/**
 * @Author:VbisoWen
 * @Description: 上传图片成功 pojo
 * @Date:Create in 20:18 2017/10/4
 * @Modified By:
 */
public class PictureResult {

    private int error;
    private String url;
    private String message;

    public PictureResult() {
    }

    public static PictureResult ok(String url) {
        return new PictureResult(0, url, null);
    }

    public static PictureResult error(String message) {
        return new PictureResult(1, null, message);
    }

    public PictureResult(int error, String url, String message) {
        this.error = error;
        this.url = url;
        this.message = message;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
