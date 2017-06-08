package fr.epita.srikanth.services;

import java.util.Properties;

import fr.epita.srikanth.services.Configuration;

	
	/**
	 * @author srikanth
	 *
	 */
	public class Configuration {
		
		
		private static Configuration instance;
		
		private String jdbcConnectionString;
		private String user;
		private String pwd;
		
		private Properties props;
		
		
		/**
		 * 
		 */
		private Configuration() 
		{}
		
		public static Configuration getInstance(){
			if (instance == null){
				instance = new Configuration();
			}
			return instance;
		}
		
		/**
		 * @return the jdbcConnectionString
		 */
		public String getJdbcConnectionString() {
			return props.getProperty("jdbc.connection.string");
		}

		public String getUser() {
			return props.getProperty("jdbc.connection.user");
		}

	
		public String getPwd() {
			return props.getProperty("jdbc.connection.pwd");
		}
		


	}



