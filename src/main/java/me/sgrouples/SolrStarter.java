package me.sgrouples;

import org.apache.solr.client.solrj.embedded.JettyConfig;
import org.apache.solr.client.solrj.embedded.JettySolrRunner;
import org.eclipse.jetty.servlet.ServletHolder;

import java.util.Collections;
import java.util.Map;
import java.util.Properties;


class SolrStarter {
    public static void main(String[] args) {
        String path = ".";
        int port = 8983;
        String context = "/solr";
        if (args.length > 0) path = args[0];
        if (args.length > 1) port = Integer.parseInt(args[1]);
        if (args.length > 2) context = args[2];
        try {
            ServletHolder sh = new ServletHolder(org.restlet.ext.servlet.ServerServlet.class);
            sh.setInitParameter("org.restlet.application", "org.apache.solr.rest.SolrSchemaRestApi");
            Map<ServletHolder, String> solrServlets = Collections.singletonMap(sh, "/schema/*");
            Properties nodeProps = new Properties();
            JettyConfig jettyConfig = JettyConfig.builder()
                    .setContext(context)
                    .setPort(port)
                    .withServlets(solrServlets)
                    .build();
            JettySolrRunner jettyRunner = new JettySolrRunner(path, nodeProps, jettyConfig);

            jettyRunner.start();
        } catch (Exception var2) {
            var2.printStackTrace();
        }
    }
}
