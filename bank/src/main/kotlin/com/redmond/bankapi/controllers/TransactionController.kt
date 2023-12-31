package com.redmond.bankapi.controllers

import com.redmond.bankapi.dto.TransactionDto
import com.redmond.bankapi.forms.PatchTransactionForm
import com.redmond.bankapi.forms.PostTransactionForm
import com.redmond.bankapi.services.TransactionService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@Tag(name = "Transactions")
@RestController
@RequestMapping("/transactions")
class TransactionController {
    @Autowired lateinit var transactionService: TransactionService

    @Operation(summary = "Get transaction")
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "Transaction found"),
        ApiResponse(responseCode = "404", description = "Transaction not found", content = [Content(schema = Schema(hidden = true))])
    ])
    @GetMapping("/{id}")
    fun getTransaction(@PathVariable id: Long) = TransactionDto(transactionService.getTransaction(id))

    @Operation(summary = "Start transaction")
    @ApiResponses(value = [
        ApiResponse(responseCode = "201", description = "Transaction created"),
        ApiResponse(responseCode = "400", description = "Invalid request", content = [Content(schema = Schema(hidden = true))])
    ])
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun postTransaction(@Valid @RequestBody form: PostTransactionForm) = TransactionDto(
        transactionService.startTransaction(form.from, form.to, form.desc, form.amount!!)
    )

    @Operation(summary = "Update transaction status")
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "Transaction updated"),
        ApiResponse(responseCode = "400", description = "Invalid request", content = [Content(schema = Schema(hidden = true))])
    ])
    @PatchMapping("/{id}")
    fun patchTransaction(
            @PathVariable id: Long,
            @Valid @RequestBody form: PatchTransactionForm
    ) = TransactionDto(transactionService.updateTransactionStatus(id, form.status!!))
}
