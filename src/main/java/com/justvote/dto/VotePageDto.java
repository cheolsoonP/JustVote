package com.justvote.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class VotePageDto {
	
	// ���̺��� ����
	private int voteID; // ��ǥ �Խñ��� pk�ѹ� DB���� auto_increament
	private String userID; // ��ǥ �Խ����� pk/fk�ѹ�
	private String voteTitle; // ��ǥ �Խñ��� Ÿ��Ʋ
	private List<String> voteContent; // ��ǥ �Խñ��� ����
	private Date voteRegDate; // ��ǥ �Խñ� �ۼ����� int������ �ٲ� �� ���� ���ư��°� ����
	private Date voteEndDate; // ��ǥ ������
	private int voteHits; // ��ǥ ��ȸ�� default 0���� �ʱ�ȭ �Ǿ��ִ�
	private int like;
	private String category;
	
	// ���ù��� ����
	private int selecID;
	private String selecContent;
	private int selecHits;
	
	private List<String> selecContentList;
}
