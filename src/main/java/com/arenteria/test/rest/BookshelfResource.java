package com.arenteria.test.rest;

import com.arenteria.test.core.exception.InternalServerErrorException;
import com.arenteria.test.core.exception.NotFoundException;
import com.arenteria.test.core.exception.ServiceException;
import com.arenteria.test.domain.dto.BookDTO;
import com.arenteria.test.service.BookshelfService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;


@Path("/api/bookshelf")
@Api(value = "/api/bookshelf", description = "Operations on books of the bookshelf")
@Produces(MediaType.APPLICATION_JSON)
public class BookshelfResource {

    private final BookshelfService bookshelfService;

    public BookshelfResource(BookshelfService bookshelfService) {
        this.bookshelfService = bookshelfService;
    }

    @GET
    @Path("/books")
    @ApiOperation(
            value = "Find books by tittle or description",
            notes = "Returns books by tittle, description or all books" +
                    " if there are no query parameters declared.",
            response = Collection.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Books by tittle,description or all books"),
            @ApiResponse(code = 404, message = "Books not found")
    })
    public Response getBooks(
            @QueryParam("tittle") String title,
            @QueryParam("description") String description) {

        Collection<BookDTO> response;

        if (title != null) {
            response = bookshelfService.findBookByTittle(title);
        } else {
            if (description != null) {
                response = bookshelfService.findBookByDescription(description);
            } else {
                response = bookshelfService.findAllBooks();
            }

        }

        if (response.isEmpty()){
            NotFoundException notFoundException = new NotFoundException(404, "Books not found");
            return Response.status(Response.Status.NOT_FOUND).entity(notFoundException).build();
        }

        return Response.ok(response).build();
    }


    @GET
    @Path("/books/{id}")
    @ApiOperation(
            value = "Find book by id.",
            notes = "Returns a book by it's id.",
            response = BookDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Book"),
            @ApiResponse(code = 404, message = "Book not found")
    })
    public Response getBook(@PathParam("id") Integer id) {

            BookDTO response = bookshelfService.findBookById(id);

            if (response != null){
                return Response.ok(response).build();
            }

            NotFoundException notFoundException = new NotFoundException(404, "Book not found");
            return Response.status(Response.Status.NOT_FOUND).entity(notFoundException).build();
    }


    @POST
    @Path("/books")
    @ApiOperation(value = "Add a new book to the bookshelf.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Book was successfully added to the bookshelf."),
            @ApiResponse(code = 500, message = "The book could not be saved duo to some error in the server.")
    })
    public Response saveBook(BookDTO bookDTO) {
        try {
            bookshelfService.saveBook(bookDTO);
            return Response.ok().entity("SUCCESS").build();
        } catch (ServiceException e) {
            InternalServerErrorException internalServerErrorException = new InternalServerErrorException(500, "The book could not be saved.");
            return Response.serverError().entity(internalServerErrorException).build();
        }
    }
}
