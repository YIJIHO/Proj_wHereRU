package kosa.hdit5spring.whereru.main.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kosa.hdit5spring.whereru.main.vo.DetailMissingBoardVo;
import kosa.hdit5spring.whereru.main.vo.MissingBoardVo;

@Mapper
public interface MissingBoardMapper {

   public void writeMissingBoard(MissingBoardVo missingBoardVo);
   DetailMissingBoardVo selectMissingBoardDetail(int missingSeq);
   void deleteMissingBoard(int missingSeq);
   void updateMissingBoard(MissingBoardVo missingBoardVo);   
   public List<MissingBoardVo> getTotalList();
   public DetailMissingBoardVo openChatActivity(int missingSeq);
   public MissingBoardVo selectMissingBoardSummaryByRoomSeq(int roomSeq);
   public MissingBoardVo selectMissingBoardSummaryByMissingSeq(int roomSeq);
}
