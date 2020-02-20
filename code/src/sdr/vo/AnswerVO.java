package sdr.vo;

public class AnswerVO {

	String banswerno;
	String acontent;
	int boardno;

	public AnswerVO() {
		super();
	}

	public AnswerVO(String banswerno, String acontent, int boardno) {
		super();
		this.banswerno = banswerno;
		this.acontent = acontent;
		this.boardno = boardno;
	}

	public String getBanswerno() {
		return banswerno;
	}

	public void setBanswerno(String banswerno) {
		this.banswerno = banswerno;
	}

	public String getAcontent() {
		return acontent;
	}

	public void setAcontent(String acontent) {
		this.acontent = acontent;
	}

	public int getBoardno() {
		return boardno;
	}

	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}

	@Override
	public String toString() {
		return "AnswerVO [banswerno=" + banswerno + ", acontent=" + acontent + ", boardno=" + boardno + "]";
	}

}
