package com.arenteria.test.truelogic.rest;

import com.arenteria.test.truelogic.core.exception.InternalServerErrorException;
import com.arenteria.test.truelogic.core.exception.NotFoundException;
import com.arenteria.test.truelogic.core.exception.ServiceException;
import com.arenteria.test.truelogic.domain.dto.BookDTO;
import com.arenteria.test.truelogic.domain.response.BookshelfResponse;
import com.arenteria.test.truelogic.service.BookshelfService;
import io.swagger.annotations.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
            value = "Find books by title or description",
            notes = "Returns books by title, description or all books" +
                    " if there are no query parameters declared.",
            response = BookshelfResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Books by title,description or all books"),
            @ApiResponse(code = 404, message = "Books not found")
    })
    public Response getBooks(
            @QueryParam("title") String title,
            @QueryParam("description") String description) {

        BookshelfResponse response;
        List<BookDTO> books;

        if (title != null) {
            books = bookshelfService.findBookByTitle(title);
        } else {
            if (description != null) {
                books = bookshelfService.findBookByDescription(description);
            } else {
                books = bookshelfService.findAllBooks();
            }

        }

        if (books.isEmpty()) {
            NotFoundException notFoundException = new NotFoundException(404, "Books not found");
            return Response.status(Response.Status.NOT_FOUND).entity(notFoundException).build();
        }

        response = new BookshelfResponse(books);

        return Response.ok(response).build();
    }


    @GET
    @Path("/books/{isbn}")
    @ApiOperation(
            value = "Find book by isbn.",
            notes = "Returns a book by it's isbn.",
            response = BookDTO.class,consumes = "{\"isbn\":\"978-1617292231\",\"title\":\"Grokking Algorithms\",\"subtitle\":\"An illustrated guide for programmers and other curious people\",\"authors\":[\"Aditya Bhargava\"],\"published\":\"2016-05-01@00:00:00.000+0000\",\"publisher\":\"Manning Publications\",\"pages\":256,\"description\":\"Grokking Algorithms is a fully illustrated, friendly guide that teaches you how to apply common algorithms to the practical problems you face every day as a programmer. You'll start with sorting and searching and, as you build up your skills in thinking algorithmically, you'll tackle more complex concerns such as data compression and artificial intelligence. Each carefully presented example includes helpful diagrams and fully annotated code samples in Python.\",\"instock\":true}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "BookEntity"),
            @ApiResponse(code = 404, message = "BookEntity not found")
    })
    public Response getBook(@PathParam("isbn") String isbn) {

        BookDTO book = bookshelfService.findBookByIsbn(isbn);

        if (book != null) {
            return Response.ok(book).build();
        }

        NotFoundException notFoundException = new NotFoundException(404, "BookEntity not found");
        return Response.status(Response.Status.NOT_FOUND).entity(notFoundException).build();
    }


    @POST
    @Path("/books")
    @ApiOperation(value = "Add a new book to the bookshelf.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "BookEntity was successfully added to the bookshelf."),
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
