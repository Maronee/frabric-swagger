package fabric;

import com.itextpdf.text.pdf.PdfWriter;
import io.github.swagger2markup.Swagger2MarkupConverter;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.asciidoctor.Asciidoctor;
import org.asciidoctor.OptionsBuilder;
import org.asciidoctor.SafeMode;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by voinea on 09.05.17.
 */
@Controller
public class ConverterController {
//
//    @RequestMapping(value="/pdf", method= RequestMethod.POST)
//    public ResponseEntity<byte[]> getPDF(@RequestBody String json) {
//        // convert JSON to Employee
////        Employee emp = convertSomehow(json);
//
//        // generate the file
////        PdfUtil.showHelp(emp);
//
//        // retrieve contents of "C:/tmp/report.pdf" that were written in showHelp
////        byte[] contents = (...);
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.parseMediaType("application/pdf"));
//        String filename = "output.pdf";
//        headers.setContentDispositionFormData(filename, filename);
//        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
////        ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(contents, headers, HttpStatus.OK);
//        return response;
//    }
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
}
