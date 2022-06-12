package com.esf.biz.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.esf.common.annotation.Excel;
import com.esf.common.core.domain.BaseEntity;

/**
 * 房屋-房东关联对象 esf_room_host
 *
 * @author esf-manager
 * @date 2022-06-03
 */
public class EsfRoomHost {
    private static final long serialVersionUID = 1L;

    /**
     * 房屋id
     */
    @Excel(name = "房屋id")
    @TableId(type = IdType.AUTO)

    private Long roomId;

    /**
     * 房东id
     */
    @Excel(name = "房东id")
    private Long hostId;

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setHostId(Long hostId) {
        this.hostId = hostId;
    }

    public Long getHostId() {
        return hostId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("roomId", getRoomId())
                .append("hostId", getHostId())
                .toString();
    }
}
