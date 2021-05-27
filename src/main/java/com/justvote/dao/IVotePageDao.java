package com.justvote.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IVotePageDao {

	// ���߿� ������ ��¥�� �߰��ؼ� �޾���� �Ѵ�, �ϴ� DB���� ���̺��� �ٲ㼭 ENDDATE�� DEFAULT ������ �־�� �� ���� 
	public void registeVoteDao(String userID, String voteTitle, String voteContent, Date voteEndDate);
	public int deleteVoteDao(@Param("_voteID")int voteID); // ��ǥ�� ����
	
	
	//����� �ٸ� ���̺��ε� �ȵȴٸ� �ٸ� DAO�� �ΰ� �� ��
	public void registeSelecDao(@Param("_voteID_FK")int voteID, @Param("_selecContent")String selecContent); // �׸� �߰��ϴ� ����
}
