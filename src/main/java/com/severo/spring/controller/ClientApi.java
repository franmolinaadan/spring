package com.severo.spring.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(name = "BYKE API",description = "Spring application with spring-boot 3.x")
public interface ClientApi {
    @Operation(
            summary = "Retrieve a list of clients",
            description = "Get all the clients in the database. Returns a list of Client objects.",
            tags = {"get","client"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200",description = "success",
                    content = {@Content(schema = @Schema(implementation = com.severo.spring.entity.Client.class))}),
            @ApiResponse(responseCode = "404",description = "not found")
    })
    List<com.severo.spring.entity.Client> getTasks();
}
