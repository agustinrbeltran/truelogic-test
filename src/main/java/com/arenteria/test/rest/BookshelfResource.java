package com.arenteria.test.rest;

import com.arenteria.test.domain.dto.BookDTO;
import com.arenteria.test.service.BookshelfService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/api/bookshelf")
@Produces(MediaType.APPLICATION_JSON)
public class BookshelfResource {

    private final BookshelfService bookshelfService;

    public BookshelfResource(BookshelfService bookshelfService) {
        this.bookshelfService = bookshelfService;
    }

    @GET
    @Path("/books")
    public Response getAllBooks(
            @QueryParam("pageSize") Integer pageSize,
            @QueryParam("pageNum") Integer pageNum) {
        return Response.ok( bookshelfService.findAllBooks(pageSize,pageNum)).build();
    }

    @GET
    @Path("/books/{id}")
    public Response getAllBooks(@PathParam("id") long id) {
        return Response.ok(bookshelfService.findBookById(id)).build();
    }


    @POST
    @Path("/books")
    public Response saveBook(BookDTO bookDTO) {
        bookshelfService.saveBook(bookDTO);
        return Response.ok().entity("SUCCESS").build();
    }
}
