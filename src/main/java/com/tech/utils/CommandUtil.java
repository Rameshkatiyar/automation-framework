package com.tech.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

@Slf4j
public class CommandUtil {

    public static String executeCommand(String command){
        Process process = null;
        String response = "";

        try {
            process = Runtime.getRuntime().exec(command);
            InputStream inputStream = process.getInputStream();

            response = new BufferedReader(
                    new InputStreamReader(inputStream, StandardCharsets.UTF_8)).lines()
                    .collect(Collectors.joining("\n"));
        } catch (IOException e) {
            log.error(e.getMessage());
        } finally {
            process.destroy();
        }

        return response;
    }
}
