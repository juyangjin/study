package org.example.jdbcmemopj.repository;

import org.example.jdbcmemopj.dto.MemoResponseDto;
import org.example.jdbcmemopj.entity.Memo;

import java.util.List;
import java.util.Optional;

public interface MemoRepository {

    MemoResponseDto saveMemo(Memo memo);

    Memo findMemoByIdOrElseThrow(Long id);

    List<MemoResponseDto> findAllMemos();
    Optional<Memo> findMemoById(Long id);
    int updateMemo(Long id, String title, String contents);
    int updateTitle(Long id, String title);
    int deleteMemo(Long id);

}