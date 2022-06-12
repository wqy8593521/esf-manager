# create
#     database if not exists esf_room_hire;
# use
#     esf_room_hire;
drop table if exists esf_room_region;

create table esf_room_region
(
    id           bigint primary key auto_increment comment 'id',
    address_code varchar(12) comment '全国地址编码',
    address_info varchar(255) comment '详细地址信息',
    region_name  varchar(64) comment '房屋区域名',
    create_by    varchar(64)  default '' comment '创建者',
    create_time  datetime comment '创建时间',
    update_by    varchar(64)  default '' comment '更新者',
    update_time  datetime comment '更新时间',
    remark       varchar(500) default null comment '备注'
) comment '房屋区域表';

drop table if exists esf_room;
create table esf_room
(
    id            bigint primary key auto_increment comment '房间id',
    region_id     bigint comment '区域id',
    room_name     varchar(255) comment '房屋名字',
    room_type     tinyint comment '房屋户型 0单间 1一室一厅 2两室一厅 3三室一厅 ..',
    room_spec     tinyint comment '房屋规格',
    room_capacity int comment '房屋容纳人数',
    room_pic      varchar(1024) comment '房屋图片',
    room_status   tinyint comment '出租状态 0空闲 1在租 2临期',
    room_cost     decimal(10, 2) comment '房屋成本（月）',
    create_by     varchar(64)  default '' comment '创建者',
    create_time   datetime comment '创建时间',
    update_by     varchar(64)  default '' comment '更新者',
    update_time   datetime comment '更新时间',
    remark        varchar(500) default null comment '备注',
    foreign key region_room (region_id) references esf_room_region (id)
) comment '房源信息表';

drop table if exists esf_host;

create table esf_host
(
    id           bigint primary key auto_increment comment '房东id',
    host_name    varchar(255) comment '房东名字',
    host_mobile  varchar(24) comment '房东电话',
    host_avatar  varchar(1024) comment '房东头像',
    host_sex     tinyint comment '房东性别',
    host_age     int comment '房东年龄',
    house_num    int comment '房源数',
    address_code varchar(12) comment '全国地址编码',
    address_info varchar(255) comment '详细地址信息',
    create_by    varchar(64)  default '' comment '创建者',
    create_time  datetime comment '创建时间',
    update_by    varchar(64)  default '' comment '更新者',
    update_time  datetime comment '更新时间',
    remark       varchar(500) default null comment '备注'
) comment '房东信息表';

drop table if exists esf_tenant;

create table esf_tenant
(
    id             bigint primary key auto_increment comment '租客id',
    tenant_name    varchar(255) comment '租客名字',
    tenant_mobile  varchar(24) comment '租客电话',
    tenant_avatar  varchar(1024) comment '租客头像',
    tenant_sex     tinyint comment '租客性别',
    tenant_age     int comment '租客年龄',
    tenant_id_card varchar(64) comment '租客身份证号',
    address_code   varchar(12) comment '全国地址编码',
    address_info   varchar(255) comment '详细地址信息',
    create_by      varchar(64)  default '' comment '创建者',
    create_time    datetime comment '创建时间',
    update_by      varchar(64)  default '' comment '更新者',
    update_time    datetime comment '更新时间',
    remark         varchar(500) default null comment '备注'
) comment '租客信息表';

drop table if exists esf_room_hire;

create table esf_room_hire
(
    id             bigint primary key auto_increment comment 'id',
    tenant_id      bigint comment '租户id',
    room_id        bigint comment '房间id',
    host_id        bigint comment '房东id',
    hire_term      int comment '租赁期限（月）',
    remain_term    int comment '剩余期数（月）',
    hire_price     decimal(10, 2) comment '租赁价格（月）',
    deposit        decimal(10, 2) comment '押金',
    deposit_status tinyint comment '押金状态 0已交 1已退 2扣押',
    hire_status    tinyint comment '租赁状态 0在租 1归还 2合同强制终止',
    payment_status tinyint comment '交租状态 0本期已交 1本期未交 2逾期未交',
    create_by      varchar(64)  default '' comment '创建者',
    create_time    datetime comment '创建时间',
    update_by      varchar(64)  default '' comment '更新者',
    update_time    datetime comment '更新时间',
    remark         varchar(500) default null comment '备注',
    foreign key tenant_room_hire (tenant_id) references esf_tenant (id),
    foreign key room_hire (room_id) references esf_room (id),
    foreign key host_hire (host_id) references esf_host (id)
) comment '房屋租赁表';


drop table if exists esf_hire_bill;

create table esf_hire_bill
(
    id          bigint primary key auto_increment comment 'id',
    hire_id     bigint comment '租赁id',
    tenant_id   bigint comment '租户id',
    room_id     bigint comment '房间id',
    bill_scene  tinyint comment '账单场景 0收租 1收押金 2退押金 3续租收租 4 退租退费 5支付成本',
    bill_type   tinyint comment '账单类型 0支出 1收入（对于中介）',
    before_num  decimal(10, 2) comment '之前金额',
    balance     decimal(10, 2) comment '影响金额',
    after_num   decimal(10, 2) comment '之后金额',
    create_by   varchar(64)  default '' comment '创建者',
    create_time datetime comment '创建时间',
    update_by   varchar(64)  default '' comment '更新者',
    update_time datetime comment '更新时间',
    remark      varchar(500) default null comment '备注',
    foreign key hire_bill (hire_id) references esf_room_hire (id),
    foreign key tenant_bill (tenant_id) references esf_tenant (id),
    foreign key room_bill (room_id) references esf_room (id)
) comment '房屋租赁账单表';


create table esf_room_host
(
    room_id bigint comment '房屋id',
    host_id bigint comment '房东id',
    foreign key esf_room_host_host (host_id) references esf_host (id),
    foreign key esf_room_host_room (room_id) references esf_room (id),
    primary key room_host (room_id, host_id)
) comment '房屋-房东关联表';