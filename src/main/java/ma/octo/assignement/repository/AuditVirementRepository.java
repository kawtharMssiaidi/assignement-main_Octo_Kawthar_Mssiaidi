package ma.octo.assignement.repository;

import ma.octo.assignement.domain.AuditTransfert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditVirementRepository extends JpaRepository<AuditTransfert, Long> {
}
