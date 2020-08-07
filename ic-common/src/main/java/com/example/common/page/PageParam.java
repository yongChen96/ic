package com.example.common.page;

import com.example.common.constant.GlobalConstant;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @ClassName: PageParam
 * @Description: 分页实体对象
 * @Author: yongchen
 * @Date: 2020/8/5 17:58
 **/
@ApiModel(value = "PageParam", description = "分页对象入参")
public class PageParam<T> implements Serializable {
    private static final long serialVersionUID = 1502692678845475027L;

    @ApiModelProperty("当前页")
    private long pageNo;

    @ApiModelProperty("每页显示数量")
    private long pageSize;

    @NotNull(message = "查询对象data不能为空")
    @ApiModelProperty("参数泛型")
    private T data;

    public PageParam() {
    }

    public long getPageNo() {
        if (this.pageNo <= 0L) {
            this.pageNo = (long) GlobalConstant.FIRST_PAGE;
        }

        return this.pageNo;
    }

    public long getPageSize() {
        if (this.pageSize <= 0L) {
            this.pageSize = (long)GlobalConstant.DEFAULT_LIMIT;
        }

        if (this.pageSize > (long)GlobalConstant.MAX_LIMIT) {
            this.pageSize = (long)GlobalConstant.MAX_LIMIT;
        }

        return this.pageSize;
    }

    public int getLimit() {
        return Integer.parseInt(String.valueOf(this.getPageNo()));
    }

    public int getOffset() {
        long offset = (this.getPageNo() - 1L) * this.getPageNo();
        return this.getPageNo() > 0L ? Integer.parseInt(String.valueOf(offset)) : 0;
    }

    @JsonIgnore
    public <T> Page<T> getPage() {
        return new Page(this.getPageNo(), this.getPageSize());
    }

    public T getData() {
        return this.data;
    }

    public void setPageNo(long pageNo) {
        this.pageNo = pageNo;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public void setData(T data) {
        this.data = data;
    }
}
