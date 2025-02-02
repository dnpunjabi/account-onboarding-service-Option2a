package com.bank.onboarding.audit;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;

@Entity
@Table(name = "api_call_logs")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiCallLogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "transaction_id")
    private String transactionId;

    @Column(name = "feature_name")
    private String featureName;

    @Column(name = "fkn")
    private String fkn;

    @Column(name = "product_code")
    private String productCode;

    @Column(name = "http_status")
    private String httpStatus;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "request_payload", columnDefinition = "jsonb")
    private String requestPayload;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "response_body", columnDefinition = "jsonb")
    private String responseBody;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}