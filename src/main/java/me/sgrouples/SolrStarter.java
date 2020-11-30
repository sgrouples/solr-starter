package me.sgrouples;

import org.apache.solr.client.solrj.embedded.JettyConfig;
import org.apache.solr.client.solrj.embedded.JettySolrRunner;

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
            Properties nodeProps = new Properties();
            JettyConfig jettyConfig = JettyConfig.builder()
                    .setContext(context)
                    .setPort(port)
                    .build();
            JettySolrRunner jettyRunner = new JettySolrRunner(path, nodeProps, jettyConfig);

            jettyRunner.start();
        } catch (Exception var2) {
            var2.printStackTrace();
        }
    }
}
