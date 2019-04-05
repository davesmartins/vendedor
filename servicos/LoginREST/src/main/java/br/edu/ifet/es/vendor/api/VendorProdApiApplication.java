package br.edu.ifet.es.vendor.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VendorProdApiApplication  {

	public static void main(String[] args) {
		SpringApplication.run(VendorProdApiApplication.class, args);
	}

        
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
//    @Autowired
//	private CategoriaRepository categoriaRepository;
//
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        logger.info("Criando Carga inicial:");  
//    
//        Categoria c1 = new Categoria(1l,"ABC");
//        Categoria c2 = new Categoria(2l,"EFG");
//        Categoria c3 = new Categoria(3l,"HIJ");
//        Categoria c4 = new Categoria(4l,"KLM");
//        
//        categoriaRepository.save(c1);
//        logger.info("Categoria 1");  
//        categoriaRepository.save(c2);
//        logger.info("Categoria 2");    
//        categoriaRepository.save(c3);
//        logger.info("Categoria 3");  
//        categoriaRepository.save(c4);
//        logger.info("Categoria 4");   
//        logger.info("Fim Carga inicial:");  
//        
//    }
	
}
