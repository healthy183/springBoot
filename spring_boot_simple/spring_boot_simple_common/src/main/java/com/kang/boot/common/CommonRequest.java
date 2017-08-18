package com.kang.boot.common;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Title 类名
 * @Description 描述
 * @Date 2017/8/15.
 * @Author Healthy
 * @Version
 */

public class CommonRequest implements Serializable {
    private static final long serialVersionUID = -449603975016674678L;
    @NotNull(message="请求流水为空")
    private String initiationID;
    private String tokenId;

    public CommonRequest() {
    }

    public String getInitiationID() {
        return this.initiationID;
    }

    public void setInitiationID(String initiationID) {
        this.initiationID = initiationID;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public boolean equals(Object o) {
        if(o == this) {
            return true;
        } else if(!(o instanceof CommonRequest)) {
            return false;
        } else {
            CommonRequest other = (CommonRequest)o;
            if(!other.canEqual(this)) {
                return false;
            } else {
                String this$initiationID = this.getInitiationID();
                String other$initiationID = other.getInitiationID();
                if(this$initiationID == null) {
                    if(other$initiationID != null) {
                        return false;
                    }
                } else if(!this$initiationID.equals(other$initiationID)) {
                    return false;
                }
                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof CommonRequest;
    }

    public int hashCode() {
        boolean PRIME = true;
        byte result = 1;
        String $initiationID = this.getInitiationID();
        int result1 = result * 59 + ($initiationID == null?0:$initiationID.hashCode());
        return result1;
    }

    public String toString() {
        return "CommonRequest(initiationID=" + this.getInitiationID() + ",tokenId=" + this.getTokenId() + ")";
    }
}

