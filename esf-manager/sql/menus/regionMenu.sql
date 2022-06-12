-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('房屋区域', '2036', '1', 'region', 'biz/region/index', 1, 0, 'C', '0', '0', 'biz:region:list', '#', 'admin', sysdate(), '', null, '房屋区域菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('房屋区域查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'biz:region:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('房屋区域新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'biz:region:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('房屋区域修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'biz:region:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('房屋区域删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'biz:region:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('房屋区域导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'biz:region:export',       '#', 'admin', sysdate(), '', null, '');
