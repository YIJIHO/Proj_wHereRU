package kosa.hdit5spring.whereru.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosa.hdit5spring.whereru.main.mapper.MissingBoardMapper;
import kosa.hdit5spring.whereru.main.vo.MissingBoardVo;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MissingBoardServiceImpl implements MissingBoardService{

   @Autowired
   MissingBoardMapper missingBoardMapper;
   
   @Override
   public void writeMissingBoard(MissingBoardVo missingBoardVo) {      
	   
      missingBoardMapper.writeMissingBoard(missingBoardVo);
      
   }
   
   @Override
   public MissingBoardVo getMissingBoardDetail(int missingSeq, String userSeq) {
	   
      MissingBoardVo detail = missingBoardMapper.selectMissingBoardDetail(missingSeq);
      
      if(detail != null && userSeq != null) {
         detail.setOwner(userSeq.equals(detail.getUserSeq()));
      }
      return detail;
   }

   
   public void deleteMissingBoard(int missingSeq, String userSeq)  {
	   
	   MissingBoardVo detail = missingBoardMapper.selectMissingBoardDetail(missingSeq);

//	   TODO: if(detail != null && userSeq != null && userSeq.equals(detail.getUserSeq())) {
		   missingBoardMapper.deleteMissingBoard(missingSeq);
   }
   
   
   public void updateMissingBoard(MissingBoardVo missingBoardVo) {
	   
	    MissingBoardVo original = missingBoardMapper.selectMissingBoardDetail(missingBoardVo.getMissingSeq());

//	    TODO: if (original != null && userSeq != null && userSeq.equals(original.getUserSeq())) {
	        missingBoardMapper.updateMissingBoard(missingBoardVo);
	   
   }
}