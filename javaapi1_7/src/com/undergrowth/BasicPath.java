package com.undergrowth;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

/**
 * A Java Path instance represents a path in the file system. A path can point
 * to either a file or a directory. A path can be absolute or relative. An
 * absolute path contains the full path from the root of the file system down to
 * the file or directory it points to. A relative path contains the path to the
 * file or directory relative to some other path.
 * 
 * @author u1
 * 
 */
public class BasicPath {

	/**
	 * 测试绝对路径
	 */
	@Test
	public void testAbsolute() {
		Path path=Paths.get("E:\\book", "JAVA_API_1.7中文.chm");
		System.out.println(path.toString());
	}

	/**
	 * 测试相对路径
	 * .---->当前路径
	 * ..---->父路径
	 */
	@Test
	public void testRelative(){
		Path path=Paths.get(".");
		System.out.println(path.toAbsolutePath());
		path=Paths.get("..");
		System.out.println(path.toAbsolutePath());
	}
	
	/**
	 * 格式化Path路径 
	 * 去除.和..
	 */
	@Test
	public void testNormalize(){
		Path path=Paths.get("E:\\book\\weblogic\\.\\51CTO下载-Oracle WebLogic Server开发权威指南.part1.rar");
		System.out.println(path.toAbsolutePath());
		System.out.println(path.normalize().toAbsolutePath());
		path=Paths.get("E:\\book\\..\\");
		System.out.println(path.toAbsolutePath());
		System.out.println(path.normalize().toAbsolutePath());
	}
	
}
