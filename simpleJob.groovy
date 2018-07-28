import jenkins.model.*
import hudson.model.*
import org.apache.http.entity.*
import groovyx.net.http.*
import org.apache.http.*
import hudson.plugins.git.GitSCM
import hudson.tasks.*
import hudson.plugins.ws_cleanup.*
import com.cloudbees.hudson.plugins.folder.*
import org.jenkinsci.plugins.*


Jenkins jenkins = Jenkins.instance
def job
job = jenkins.createProject(FreeStyleProject.class, "name")
job.getBuildWrappersList().add(new PreBuildCleanup( new ArrayList<Pattern>(), false,"","") );
job.setScm(new GitSCM(i'git'));
job.getBuildersList().add(new hudson.tasks.Shell('echo "Hello World"'));
job.save()

def matchedJobs = Jenkins.instance.items.findAll { check ->
    println check
}

