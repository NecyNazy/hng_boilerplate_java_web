package hng_java_boilerplate.blogPosts.controller;

import hng_java_boilerplate.blogPosts.entity.BlogPost;
import hng_java_boilerplate.blogPosts.service.BlogPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/blogs")
@RequiredArgsConstructor
public class BlogPostController {
    private final BlogPostService blogPostService;

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/{blog_id}")
    public ResponseEntity<BlogPost> getById(@PathVariable String blogId) {
        Optional<BlogPost> blogPost = blogPostService.getById(blogId);
        return blogPost.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping
    public ResponseEntity<Collection<BlogPost>> getAll() {
        Collection<BlogPost> blogPosts = blogPostService.getAll();
        return ResponseEntity.ok(blogPosts);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/latest")
    public ResponseEntity<BlogPost> getLatestPost() {
        Optional<BlogPost> latestPost = blogPostService.latestPost();
        return latestPost.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping
    public ResponseEntity<BlogPost> createBlogPost(@RequestBody BlogPost blogPost) {
        BlogPost savedPost = blogPostService.save(blogPost);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPost);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @DeleteMapping("/{blog_id}")
    public ResponseEntity<Void> deleteBlogPost(@PathVariable String blogId) {
        Optional<BlogPost> blogPost = blogPostService.getById(blogId);
        if (blogPost.isPresent()) {
            blogPostService.delete(blogPost.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
