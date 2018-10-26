#通用service，提供方法处理简单的单表增删改查，分页查询，数量统计
使用说明：

1.对单表进行逆向生成Entity.java(继承BaseEntity.java),Example.java(继承BaseExample.java),Mapper.java(继承BaseMapper.java),Mapper.xml,分别放入工程内

2.各业务service继承BaseService即可使用通用方法,如增删改查,分页查询,数量统计
