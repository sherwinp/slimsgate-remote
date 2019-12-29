package gov.fda.messagingclient.script;

import java.io.File;
import java.nio.file.FileSystemNotFoundException;

import jep.Jep;
import jep.JepConfig;
import jep.JepException;

public final class PythonInterpreter {

	public static void main(String[] args) {
		new PythonInterpreter().runScript(args[0]);
	}
	public final void runScript(String idscriptpath){

		File script = new File(String.format("src/main/python/%s", idscriptpath.replace("..", "")));
		
		try {
			if( script.exists()) {
				try(Interpreter interpreter = new Interpreter()){
					interpreter.runScript(script.getPath());
				}
			}else {
				throw new FileSystemNotFoundException(idscriptpath);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	class Interpreter extends Jep{
		public Interpreter() throws JepException{
			super(new JepConfig().setClassLoader(Thread.currentThread().getContextClassLoader()), false);
		}
	}

}