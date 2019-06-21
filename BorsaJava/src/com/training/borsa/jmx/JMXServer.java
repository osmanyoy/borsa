package com.training.borsa.jmx;

import java.lang.management.ManagementFactory;
import java.util.logging.Logger;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;

public class JMXServer {

    public static void main(String[] args) {
        ObjectName objectName = null;
        try {
            objectName = new ObjectName("com.borsa.jmx:type=basic,name=game");
        } catch (MalformedObjectNameException e) {
            e.printStackTrace();
        }
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        Test gameObj = new Test();
        try {
            server.registerMBean(gameObj, objectName);
        } catch (InstanceAlreadyExistsException | MBeanRegistrationException | NotCompliantMBeanException e) {
            e.printStackTrace();
        }        while (true) {
        	try {
				Thread.sleep(10_000);
			} catch (Exception e) {
			}
        }
    }
}
