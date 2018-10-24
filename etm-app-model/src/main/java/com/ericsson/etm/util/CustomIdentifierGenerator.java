package com.ericsson.etm.util;

import java.io.Serializable;
import java.util.Properties;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.internal.util.config.ConfigurationHelper;
import org.hibernate.type.Type;

public final class CustomIdentifierGenerator implements IdentifierGenerator, Configurable {

    private String prefix;
    //private String tableName;
    private String format;
    private static final String SEQUENCE_FORMAT = "%08d";
    private static final String SEQUENCE_PREFIX = "SEQ";
    //private static final String SEQUENCE_TABLE_NAME = "tableName";

	@SuppressWarnings("static-access")
	@Override
	public void configure(Type type, Properties params, Dialect d) throws MappingException {
        this.prefix= ConfigurationHelper.getString(this.SEQUENCE_PREFIX, params,"SEQ");
        this.format= ConfigurationHelper.getString(this.SEQUENCE_FORMAT, params,"%08d");
        //this.tableName = ConfigurationHelper.getString(this.SEQUENCE_TABLE_NAME, params);		
	}

	@Override
	public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
		Random rand = new Random();
		return this.prefix+String.format(format, rand.nextInt(10000));
	}  

}
