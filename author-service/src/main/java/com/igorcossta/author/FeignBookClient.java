package com.igorcossta.author;

import com.igorcossta.author.config.FeignClientConfig;
import com.igorcossta.common.book.BookDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "book", path = "api/v1/book", configuration = FeignClientConfig.class)
public interface FeignBookClient {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    ResponseEntity<List<BookDTO>> getBookByAuthorId(@RequestParam(name = "author") int author);
}
