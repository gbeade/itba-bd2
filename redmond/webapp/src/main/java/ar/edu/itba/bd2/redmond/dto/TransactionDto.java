package ar.edu.itba.bd2.redmond.dto;

import ar.edu.itba.bd2.redmond.model.Transaction;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;
import java.time.Instant;

public class TransactionDto {
    private final String id;
    private final Instant timestamp;
    private final String source;
    private final String destination;
    private final BigDecimal amount;
    private final String description;
    private final String status;

    public TransactionDto(Transaction t) {
        this.id = String.valueOf(t.getTransactionId());
        this.source = t.getSource();
        this.destination = t.getDestination();
        this.amount = t.getAmount();
        this.description = t.getDescription();
        this.status = t.getStatus().toString().toLowerCase();
        this.timestamp = t.getTimestamp();
    }

    public String getId() {
        return id;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }
}
