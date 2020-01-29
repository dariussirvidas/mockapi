package com.kitm.mockapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.MOVED_PERMANENTLY)
public class Exception301 extends RuntimeException {}
