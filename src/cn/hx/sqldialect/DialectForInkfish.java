package cn.hx.sqldialect;

import java.sql.Types;

import org.hibernate.dialect.MySQL5Dialect;

public class DialectForInkfish extends MySQL5Dialect{
  
	
	//数据库表中有text类型的字段，而Hibernate在native查询中没有注册这个字段，因此发生这个错误。
	public DialectForInkfish() {  
        super();  
        registerHibernateType(Types.LONGVARCHAR, 65535, "text");  
    }  
}
