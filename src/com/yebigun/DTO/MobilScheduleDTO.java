package com.yebigun.DTO;

public class MobilScheduleDTO
{
	private String seq;
      private String startdate;
      private String pay;
      private String tseq;
      private String fseq;
      private String pseq;
      public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getPseq() {
		return pseq;
	}
	public void setPseq(String pseq) {
		this.pseq = pseq;
	}
	public String getStartdate()
      {
            return startdate;
      }
      public void setStartdate(String startdate)
      {
            this.startdate = startdate;
      }
      public String getPay()
      {
            return pay;
      }
      public void setPay(String pay)
      {
            this.pay = pay;
      }
      public String getTseq()
      {
            return tseq;
      }
      public void setTseq(String tseq)
      {
            this.tseq = tseq;
      }
      public String getFseq()
      {
            return fseq;
      }
      public void setFseq(String fseq)
      {
            this.fseq = fseq;
      }
}
