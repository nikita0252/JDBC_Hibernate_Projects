package m2oUni;



	import jakarta.persistence.Entity;
 	import jakarta.persistence.Id;




	@Entity
	public class Department 
	{
		@Id
		private int did;
		private String dname;
		

		public int getDid() {
			return did;
		}

		public void setDid(int did) {
			this.did = did;
		}

		public String getDname() {
			return dname;
		}

		public void setDname(String dname) {
			this.dname = dname;
		}

		
		
		
		
		

	}



