package com.iscas.biz.samples;

import com.iscas.base.biz.service.fileserver.FileServerService;
import com.iscas.common.tools.core.io.zip.ZipUtils;
import com.iscas.templet.common.BaseController;
import com.iscas.templet.common.ResponseEntity;
import com.iscas.templet.exception.BaseException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

/**
 * //文件上传与下载示例
 *
 * @author
 * @vesion 1.0
 * @date 2021/1/4 10:58
 * @since jdk1.8
 */
@RestController
@RequestMapping("/test/file")
@Api(tags="文件上传")
public class FileLoadControllerTest extends BaseController {

    @Autowired
    private FileServerService fileServerService;

    /**
     * 文件上传，支持多文件上传
     * @param file
     * @return
     * @throws BaseException
     */
    @ApiOperation(value="[文件服务/xxx]单个文件上传", notes="[文件服务/xxx]文件上传")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "file", value = "上传的文件,支持多个文件，文件的key为file", required = true, dataType = "MultipartFile")
            }
    )
    @PostMapping("/upload/single")
    public ResponseEntity uploadSingleTest(@RequestBody MultipartFile file) throws BaseException {
        ResponseEntity response = getResponse();
        try {
            MultipartFile[] multipartFiles = new MultipartFile[1];
            multipartFiles[0] = file;
            Map<String, String> result = fileServerService.upload(multipartFiles);
            response.setValue(result);
        } catch (IOException e) {
            throw new BaseException("文件上传出错", e);
        }
        return response;
    }

    /**
     * 文件上传，支持多文件上传
     * @param files
     * @return
     * @throws BaseException
     */
    @ApiOperation(value="[文件服务/xxx]文件上传", notes="[文件服务/xxx]文件上传")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "files", value = "上传的文件,支持多个文件，文件的key为files", required = true, dataType = "MultipartFile[]")
            }
    )
    @PostMapping("/upload")
    public ResponseEntity uploadTest(@RequestBody MultipartFile[] files) throws BaseException {
        ResponseEntity response = getResponse();

        if (ArrayUtils.isEmpty(files)) {
            throw new BaseException("上传的数据为空");
        }
        try {
            Map<String, String> result = fileServerService.upload(files);
            response.setValue(result);
        } catch (IOException e) {
            throw new BaseException("文件上传出错", e);
        }
        return response;
    }

    /**
     * 根据文件路径文件下载
     * @param path
     * @throws BaseException
     */
    @ApiOperation(value="[文件服务/xxx]文件下载", notes="[文件服务/xxx]文件下载")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "path", value = "下载的文件路径(RequestParam)", required = true, dataType = "String")
            }
    )
    @GetMapping("/download")
    public void downloadTest(@RequestParam("path") String path) throws BaseException {
        if (StringUtils.isEmpty(path)) {
            throw new BaseException("文件路径为空");
        }
        fileServerService.download(path);
    }

    /**
     * 根据文件路径，对文件进行zip压缩，并提供文件下载
     * @param path
     * @throws BaseException
     */
    @ApiOperation(value="[文件服务/xxx]文件路径压缩zip下载", notes="[文件服务/xxx]文件路径压缩zip下载")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "path", value = "下载的文件路径(RequestParam)", required = true, dataType = "String")
            }
    )
    @GetMapping("/downloadzip")
    public void downloadZipTest(@RequestParam("path") String path) throws BaseException {
        if (StringUtils.isEmpty(path)) {
            throw new BaseException("文件路径为空");
        }

        String tempPath = "D:/ziptest/";
        ZipUtils.unZip(new File(path), tempPath);
        fileServerService.download(path);
    }

}
