package com.transample.demo.dto;

import lombok.Data;

@Data
public class RemoveIdsDTO {
    /**
     * 批量删除的id，用逗号分隔
     */
    String ids;

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }
}
