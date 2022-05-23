package com.igorcossta.author.config;

import com.google.common.io.CharStreams;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;

/*
    https://stackoverflow.com/questions/56352215/how-implement-error-decoder-for-multiple-feign-clients
 */
@Configuration
public class FeignClientConfig {

    @Bean
    public CustomErrorDecoder customErrorDecoder() {
        return new CustomErrorDecoder();
    }

    static class CustomErrorDecoder implements ErrorDecoder {

        //        https://stackoverflow.com/questions/63068575/feign-error-decoder-with-custom-json-response
        @Override
        public Exception decode(String methodKey, Response response) {
            Reader reader = null;
            try {
                reader = response.body().asReader(Charset.defaultCharset());
                String result = CharStreams.toString(reader);
                System.out.println(result);

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return new RuntimeException("BAM!");
        }

    }
}
