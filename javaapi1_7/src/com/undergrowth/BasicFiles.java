package com.undergrowth;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;

import org.junit.Test;

/**
 * The Java NIO Files class (java.nio.file.Files) provides several methods for
 * manipulating files in the file system.
 * 文件操作类
 *    新建两个文件夹 再将文件复制到两文件夹中 然后进行遍历文件树 遍历完成后 删除文件夹及文件
 * @author u1
 * 
 */
public class BasicFiles {

	@Test
	public void test() throws IOException {
		//获取路径
		Path path=Paths.get(".\\test");
		//分别创建两个文件夹 在test里面 分别为test1 和  test2
		createDir(path);
		//复制文件
		copyFiles(path);
		//遍历文件
		path=Paths.get(".\\test");
		walkFile(path);
	}

	/**
	 * 遍历文件目录
	 * @param path
	 * @throws IOException 
	 */
	private void walkFile(Path path) throws IOException {
		// TODO Auto-generated method stub
		Files.walkFileTree(path, new SimpleFileVisitor<Path>(){

			@Override
			public FileVisitResult visitFile(Path file,
					BasicFileAttributes attrs) throws IOException {
				// TODO Auto-generated method stub
				//删除文件
				System.out.println("删除"+file.toFile().getAbsolutePath());
				Files.delete(file);
				return FileVisitResult.CONTINUE;
			}

			@Override
			public FileVisitResult postVisitDirectory(Path dir, IOException exc)
					throws IOException {
				// TODO Auto-generated method stub
				//遍历完目录后删除
				System.out.println("遍历完目录后删除"+dir.toAbsolutePath());
				Files.delete(dir);
				return FileVisitResult.CONTINUE;
			}
			
		});
	}

	/**
	 * 复制文件
	 * @param path
	 * @throws IOException 
	 */
	private void copyFiles(Path path) throws IOException {
		// TODO Auto-generated method stub
		Path pathSource =Paths.get("..\\git.txt");
		path=Paths.get(".\\test\\test1\\git.txt");
		//替换已经存在的文件
		Files.copy(pathSource, path,StandardCopyOption.REPLACE_EXISTING);
		path=Paths.get(".\\test\\test2\\git.txt");
		Files.copy(pathSource, path,StandardCopyOption.REPLACE_EXISTING);
	}

	/**
	 * 创建文件夹
	 * @param path
	 * @throws IOException
	 */
	private void createDir(Path path) throws IOException {
		// TODO Auto-generated method stub
		if(!Files.exists(path, new LinkOption[]{LinkOption.NOFOLLOW_LINKS}))
			Files.createDirectories(path);
		path=Paths.get(path.toString(), "test1");
		if(!Files.exists(path, new LinkOption[]{LinkOption.NOFOLLOW_LINKS}))
			Files.createDirectories(path);
		path=Paths.get(path.toString(), "..\\test2");
		if(!Files.exists(path, new LinkOption[]{LinkOption.NOFOLLOW_LINKS}))
			Files.createDirectories(path);
	}

	
}
