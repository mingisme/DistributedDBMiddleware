CREATE TABLE user
(
	id BIGINT(20) NOT NULL COMMENT '主键ID',
	name VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名',
	age INT(11) NULL DEFAULT NULL COMMENT '年龄',
	email VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱',
	PRIMARY KEY (id)
);

CREATE TABLE `available_rec` (
  `id` BIGINT(20) NOT NULL,
  `asset_name` varchar(400) COLLATE utf8mb4_unicode_ci NOT NULL,
  `owner_id` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `rec_id` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `registry_id` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `rec_registry` (
  `id` BIGINT(20)  NOT NULL,
  `name` varchar(400) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
);