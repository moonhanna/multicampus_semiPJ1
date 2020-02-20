package sdr.vo;


public class BoardVO {
	int boardno;
	String userid;
	String bcontent;
	String bdate;
	String prodname;
	String btype;
	int bstar;
	
	
	public BoardVO() {
		super();
	}


	public BoardVO(int boardno, String userid, String bcontent, String bdate, String prodname, String btype,
			int bstar) {
		super();
		this.boardno = boardno;
		this.userid = userid;
		this.bcontent = bcontent;
		this.bdate = bdate;
		this.prodname = prodname;
		this.btype = btype;
		this.bstar = bstar;
	}


	public int getBoardno() {
		return boardno;
	}


	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}


	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	public String getBcontent() {
		return bcontent;
	}


	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}


	public String getBdate() {
		return bdate;
	}


	public void setBdate(String bdate) {
		this.bdate = bdate;
	}


	public String getProdname() {
		return prodname;
	}


	public void setProdname(String prodname) {
		this.prodname = prodname;
	}


	public String getBtype() {
		return btype;
	}


	public void setBtype(String btype) {
		this.btype = btype;
	}


	public int getBstar() {
		return bstar;
	}


	public void setBstar(int bstar) {
		this.bstar = bstar;
	}


	@Override
	public String toString() {
		return "BoardVO [boardno=" + boardno + ", userid=" + userid + ", bcontent=" + bcontent + ", bdate=" + bdate
				+ ", prodname=" + prodname + ", btype=" + btype + ", bstar=" + bstar + "]";
	}
	
	
}
	
