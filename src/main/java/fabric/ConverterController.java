package fabric;

import io.github.swagger2markup.Swagger2MarkupConverter;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.asciidoctor.Asciidoctor;
import org.asciidoctor.OptionsBuilder;
import org.asciidoctor.SafeMode;
import org.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Map;

/**
 * Created by voinea on 09.05.17.
 */
@Controller
public class ConverterController {
//
//    @ResponseBody
//    @RequestMapping(value="/pdf", method= RequestMethod.POST)
//    public void getPDF(@RequestBody String data, HttpServletResponse response) {
//        // convert JSON to Employee
////        Employee emp = convertSomehow(json);
//
//        // generate the file
////        PdfUtil.showHelp(emp);
//
//        // retrieve contents of "C:/tmp/report.pdf" that were written in showHelp
//        byte[] contents = null;
//        File tmp = null;
//        try {
//            tmp = new File("tmp.pdf");
//            Swagger2MarkupConverter convert = Swagger2MarkupConverter.from(data).build();
//            Map<String,Object> options = OptionsBuilder.options()
//                    .backend("pdf")
//                    .safe(SafeMode.UNSAFE)
//                    .toFile(tmp)
//
//                    .asMap();
//
//            Asciidoctor asciidoctor = Asciidoctor.Factory.create();
//            asciidoctor.convert(convert.toString(), options);
//            contents = FileUtils.readFileToByteArray(tmp);
//            response.setContentType("application/pdf");
//            response.setHeader("Content-disposition", "attachment; filename=swagger.pdf");
//            response.setContentLength(contents.length);
//
//            response.getOutputStream().write(contents);
//            response.getOutputStream().flush();
////            IOUtils.copy(new FileInputStream(tmp), response.getOutputStream());
////            response.setContentType("application/pdf");
////            response.setHeader("Content-Disposition", "inline; filename='swagger.pdf'");
////            response.flushBuffer();
//        } catch (IOException e) {
//
//            e.printStackTrace();
//        } finally {
//            if(tmp.exists()){
//                tmp.delete();
//            }
//        }
////
////        IOUtils
////        HttpHeaders headers = new HttpHeaders();
////        headers.setContentType(MediaType.parseMediaType("application/pdf"));
////        String filename = "swagger.pdf";
////        headers.setContentDispositionFormData(filename, filename);
////        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
////        ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(contents, headers, HttpStatus.OK);
////        response.set
////        return response;
//    }


    @ResponseBody
    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping(value="/pdf", method= RequestMethod.POST)
    public void getPDF(@RequestBody String data, HttpServletResponse response) {
        // convert JSON to Employee
//        Employee emp = convertSomehow(json);

        // generate the file
//        PdfUtil.showHelp(emp);

        // retrieve contents of "C:/tmp/report.pdf" that were written in showHelp
        try{
        JSONObject obj = new JSONObject(data);
        data = obj.getString("data");
        } catch (Exception e){
            System.out.println("No JsonObject");
        }
        byte[] contents = null;
        File tmp = null;
        try {
            tmp = new File("swagger.pdf");
            Swagger2MarkupConverter convert = Swagger2MarkupConverter.from(data).build();
            Map<String,Object> options = OptionsBuilder.options()
                    .backend("pdf")
                    .safe(SafeMode.UNSAFE)
                    .toFile(tmp)

                    .asMap();

            Asciidoctor asciidoctor = Asciidoctor.Factory.create();
            asciidoctor.convert(convert.toString(), options);

            response.setContentType("application/pdf");
            response.setHeader("Content-disposition", "attachment; filename=" + tmp.getName());
//            response.setContentLength(contents.length);

            OutputStream out = response.getOutputStream();
            FileInputStream in = new FileInputStream(tmp);
            IOUtils.copy(in,out);

            out.close();
            in.close();
        } catch (IOException e) {

            e.printStackTrace();
        } finally {
            if(tmp.exists()){
                tmp.delete();
            }
        }
    }

//
//    private static void createPdf(String in){
//        Swagger2MarkupConverter converter = Swagger2MarkupConverter.from(in).build();
//        Asciidoctor asciidoctor = Asciidoctor.Factory.create();
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        File test = new File("test.pdf");
//        Map options = OptionsBuilder.options().backend("pdf").safe(SafeMode.UNSAFE).toFile(false).toFile(test).asMap();
//        asciidoctor.convert(converter.toString(), options);
//        System.out.println("done?");
//    }


    static byte[] toPDf(String content) throws IOException {
        File tmp = new File("tmp.pdf");
        Swagger2MarkupConverter convert = Swagger2MarkupConverter.from(content).build();
        Map<String,Object> options = OptionsBuilder.options()
                .backend("pdf")
                .safe(SafeMode.UNSAFE)
                .toFile(tmp)
                .asMap();

        Asciidoctor asciidoctor = Asciidoctor.Factory.create();
        asciidoctor.convert(content, options);

        byte[] bytes = IOUtils.toByteArray(new FileInputStream(tmp));
        tmp.delete();
        return bytes;

    }
}
