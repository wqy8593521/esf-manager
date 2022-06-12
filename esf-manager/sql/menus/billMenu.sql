-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('房屋租赁账单', '2036', '1', 'bill', 'biz/bill/index', 1, 0, 'C', '0', '0', 'biz:bill:list', '#', 'admin', sysdate(), '', null, '房屋租赁账单菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('房屋租赁账单查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'biz:bill:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('房屋租赁账单新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'biz:bill:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('房屋租赁账单修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'biz:bill:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('房屋租赁账单删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'biz:bill:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('房屋租赁账单导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'biz:bill:export',       '#', 'admin', sysdate(), '', null, '');
