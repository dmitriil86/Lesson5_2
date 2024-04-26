INSERT INTO tpp_ref_account_type (internal_id, value)
VALUES (1,'Клиентский'),
       (2, 'Внутрибанковский');

INSERT INTO tpp_ref_product_class (internal_id, value, gbi_code, gbi_name, product_row_code, product_row_name, subclass_code, subclass_name)
VALUES (1, '03.012.002', '03', 'Розничный бизнес', '012', 'Драг. металлы', '002', 'Хранение'),
       (2, '02.001.005', '02', 'Розничный бизнес', '001', 'Сырье', '005', 'Продажа');

INSERT INTO tpp_ref_product_register_type (internal_id, value
                                           , register_type_name
                                           , product_class_code
                                           , account_type)
VALUES (1, '03.012.002_47533_ComSoLd', 'Хранение ДМ.', '03.012.002', 'Клиентский'),
       (2, '02.001.005_45343_CoDowFF', 'Серебро. Выкуп.', '02.001.005', 'Клиентский');
--        ('RKO', 'Расчетный счет', 'RKO', TIMESTAMP '2023-12-03 00:00:00', 'CLIENT_ACCOUNT');

INSERT INTO account_pool (id,branch_code
                          , currency_code
                          , mdm_code
                          , priority_code
                          , registry_type_code)
VALUES (1,'0022', '800', '15', '00', '03.012.002_47533_ComSoLd'),
       (2,'0021', '500', '13', '00', '02.001.005_45343_CoDowFF');

INSERT INTO account(id, account_pool_id, account_number, bussy)
SELECT 1, id, '475335516415314841861', false
FROM account_pool
WHERE registry_type_code = '03.012.002_47533_ComSoLd';

INSERT INTO account(id, account_pool_id, account_number, bussy)
select 2, id, '4753321651354151', false
FROM account_pool
WHERE registry_type_code = '03.012.002_47533_ComSoLd';

INSERT INTO account(id, account_pool_id, account_number, bussy)
select 3, id, '4753352543276345', false
FROM account_pool
WHERE registry_type_code = '03.012.002_47533_ComSoLd';

INSERT INTO account(id, account_pool_id, account_number, bussy)
SELECT 4, id, '453432352436453276', false
FROM account_pool
WHERE registry_type_code = '02.001.005_45343_CoDowFF';

INSERT INTO account(id, account_pool_id, account_number, bussy)
SELECT 5, id, '45343221651354151', false
FROM account_pool
WHERE registry_type_code = '02.001.005_45343_CoDowFF';

INSERT INTO account(id, account_pool_id, account_number, bussy)
SELECT 6, id, '4534352543276345', false
FROM account_pool
WHERE registry_type_code = '02.001.005_45343_CoDowFF';
