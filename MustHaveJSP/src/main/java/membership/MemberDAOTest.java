package membership;

import java.util.ArrayList;

public class MemberDAOTest {

	private static MemberDAO memberDAO = new MemberDAO();
	public static void printMemberDTO() {
		MemberDTO memberDTO = memberDAO.getMemberDTO("test1", "1111");
		System.out.println(memberDTO);
		
	}
	public static void printAllMemberDTO() {
		//Test getAllMemberDTO()
		ArrayList<MemberDTO> list = memberDAO.getAllMemberDTO();
		for(MemberDTO m : list) {
			System.out.println(m);
		}
		
	}
	public static void insertMemberDTO() {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("Hong");
		memberDTO.setPass("1234");
		memberDTO.setName("홍길동");
		memberDAO.insertMemberDTO(memberDTO);
	}
	public static void updateMemberDTO() {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setPass("1111");
		memberDTO.setName("홍민기");
		memberDTO.setId("Hong");
		memberDAO.updateMemberDTO(memberDTO);
	}
	public static void deleteMemberDTO() {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("Hong");
		memberDAO.deleteMemberDTO(memberDTO);
	}
	public static void main(String[] args) {
		//printMemberDTO();
		printAllMemberDTO();
		System.out.println("insert"+"-".repeat(80));
		insertMemberDTO();
		printAllMemberDTO();
		System.out.println("update"+"-".repeat(80));
		updateMemberDTO();
		printAllMemberDTO();
		System.out.println("delete"+"-".repeat(80));
		deleteMemberDTO();
		printAllMemberDTO();
		System.out.println("-".repeat(80));
	}
}
