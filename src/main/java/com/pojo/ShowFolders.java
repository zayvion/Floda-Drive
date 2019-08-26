package com.pojo;

import java.util.List;

/**
 * @Auther: dc
 * @Date: 2019/8/26 16:59
 * @Description:
 */
public class ShowFolders {
    private int code = 0;
    private String msg;
    private int count = 1000;
    private List<TbFolder> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<TbFolder> getData() {
        return data;
    }

    public void setData(List<TbFolder> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ShowFolders{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", count=" + count +
                ", data=" + data +
                '}';
    }
}
