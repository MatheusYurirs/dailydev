package br.com.yuri.dailydev.repository;

import br.com.yuri.dailydev.model.DailyEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailyEntryRepository extends JpaRepository<DailyEntry, Long> {
}
