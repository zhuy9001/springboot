package com.pgl.demo.datasource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.sun.tools.internal.ws.wsdl.document.jaxws.Exception;

/**
 * 描述：
 * 
 * @author zhuy 邮箱: zhuyang@pgl-world.com 创建时间：2017年10月26日 下午4:50:57
 */
@Aspect
@Order(-10) // 保证该AOP在@Transactional之前执行
@Component
public class DynamicDataSourceAspect {
	private static final Logger logger = LoggerFactory.getLogger(DynamicDataSourceAspect.class);

	@Pointcut("execution(* com.pgl.demo.service.impl..*.*FromDB(..))")
	public void excude() {
	}

	// @Before("@annotation(ds)")
	@Before("excude()")
	public void changeDataSource(JoinPoint point) throws Throwable {
		//String dsId = ds.name();
		Object obj = point.getArgs()[0];
		if(obj instanceof String) {
			String dsName=obj.toString();
			if (!DynamicDataSourceContextHolder.containsDataSource(dsName)) {
				logger.error("数据源[{}]不存在，使用默认数据源 > {}", obj, point.getSignature());
				throw new Throwable("数据源["+dsName+"]不存在");
			} else {
				logger.info("Use DataSource : {} > {}", dsName, point.getSignature());
				DynamicDataSourceContextHolder.setDataSourceType(dsName);
			}
			logger.info("-----------args DataSource : {} > {}", dsName, point.getSignature());
		}else {
			logger.error("数据源[{}]不存在", obj);
			 throw new Throwable("数据源["+obj+"]不存在");
		}
		
	}

	// @After("@annotation(ds)")
	@After("excude()")
	public void restoreDataSource(JoinPoint point) {
		Object obj = point.getArgs()[0];
		 logger.info("Revert DataSource : {} > {}", obj.toString(), point.getSignature());
		 DynamicDataSourceContextHolder.clearDataSourceType();
	}
}
