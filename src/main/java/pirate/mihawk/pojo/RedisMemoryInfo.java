package pirate.mihawk.pojo;

/**
 * @program: mihawk
 * @description: Redis内存信息
 * @author: buck
 * @create: 2020-05-17 22:29
 **/
public class RedisMemoryInfo {
    private long user_memory;
    private String used_memory_human;
    private long used_memory_rss;
    private String used_memory_rss_human;
    private long used_memory_peak;
    private String used_memory_peak_human;
    private String used_memory_peak_perc;
    private long used_memory_overhead;
    private long used_memory_startup;
    private long used_memory_dataset;
    private String used_memory_dataset_perc;
    private long allocator_allocated;
    private long allocator_active;
    private long allocator_resident;
    private long total_system_memory;
    private String total_system_memory_human;
    private long used_memory_lua;
    private String used_memory_lua_human;
    private int used_memory_scripts;
    private String used_memory_scripts_human;
    private int number_of_cached_scripts;
    private long maxmemory;
    private String maxmemory_human;
    private String maxmemory_policy;
    private double allocator_frag_ratio;
    private long allocator_frag_bytes;
    private double allocator_rss_ratio;
    private long allocator_rss_bytes;
    private double rss_overhead_ratio;
    private long rss_overhead_bytes;
    private double mem_fragmentation_ratio;
    private long mem_fragmentation_bytes;
    private long mem_not_counted_for_evict;
    private long mem_replication_backlog;
    private int mem_clients_slaves;
    private int mem_clients_normal;
    private int mem_aof_buffer;
    private String mem_allocator;
    private int active_defrag_running;
    private int lazyfree_pending_objects;

    public long getUser_memory() {
        return user_memory;
    }

    public void setUser_memory(long user_memory) {
        this.user_memory = user_memory;
    }

    public String getUsed_memory_human() {
        return used_memory_human;
    }

    public void setUsed_memory_human(String used_memory_human) {
        this.used_memory_human = used_memory_human;
    }

    public long getUsed_memory_rss() {
        return used_memory_rss;
    }

    public void setUsed_memory_rss(long used_memory_rss) {
        this.used_memory_rss = used_memory_rss;
    }

    public String getUsed_memory_rss_human() {
        return used_memory_rss_human;
    }

    public void setUsed_memory_rss_human(String used_memory_rss_human) {
        this.used_memory_rss_human = used_memory_rss_human;
    }

    public long getUsed_memory_peak() {
        return used_memory_peak;
    }

    public void setUsed_memory_peak(long used_memory_peak) {
        this.used_memory_peak = used_memory_peak;
    }

    public String getUsed_memory_peak_human() {
        return used_memory_peak_human;
    }

    public void setUsed_memory_peak_human(String used_memory_peak_human) {
        this.used_memory_peak_human = used_memory_peak_human;
    }

    public String getUsed_memory_peak_perc() {
        return used_memory_peak_perc;
    }

    public void setUsed_memory_peak_perc(String used_memory_peak_perc) {
        this.used_memory_peak_perc = used_memory_peak_perc;
    }

    public long getUsed_memory_overhead() {
        return used_memory_overhead;
    }

    public void setUsed_memory_overhead(long used_memory_overhead) {
        this.used_memory_overhead = used_memory_overhead;
    }

    public long getUsed_memory_startup() {
        return used_memory_startup;
    }

    public void setUsed_memory_startup(long used_memory_startup) {
        this.used_memory_startup = used_memory_startup;
    }

    public long getUsed_memory_dataset() {
        return used_memory_dataset;
    }

    public void setUsed_memory_dataset(long used_memory_dataset) {
        this.used_memory_dataset = used_memory_dataset;
    }

    public String getUsed_memory_dataset_perc() {
        return used_memory_dataset_perc;
    }

    public void setUsed_memory_dataset_perc(String used_memory_dataset_perc) {
        this.used_memory_dataset_perc = used_memory_dataset_perc;
    }

    public long getAllocator_allocated() {
        return allocator_allocated;
    }

    public void setAllocator_allocated(long allocator_allocated) {
        this.allocator_allocated = allocator_allocated;
    }

    public long getAllocator_active() {
        return allocator_active;
    }

    public void setAllocator_active(long allocator_active) {
        this.allocator_active = allocator_active;
    }

    public long getAllocator_resident() {
        return allocator_resident;
    }

    public void setAllocator_resident(long allocator_resident) {
        this.allocator_resident = allocator_resident;
    }

    public long getTotal_system_memory() {
        return total_system_memory;
    }

    public void setTotal_system_memory(long total_system_memory) {
        this.total_system_memory = total_system_memory;
    }

    public String getTotal_system_memory_human() {
        return total_system_memory_human;
    }

    public void setTotal_system_memory_human(String total_system_memory_human) {
        this.total_system_memory_human = total_system_memory_human;
    }

    public long getUsed_memory_lua() {
        return used_memory_lua;
    }

    public void setUsed_memory_lua(long used_memory_lua) {
        this.used_memory_lua = used_memory_lua;
    }

    public String getUsed_memory_lua_human() {
        return used_memory_lua_human;
    }

    public void setUsed_memory_lua_human(String used_memory_lua_human) {
        this.used_memory_lua_human = used_memory_lua_human;
    }

    public int getUsed_memory_scripts() {
        return used_memory_scripts;
    }

    public void setUsed_memory_scripts(int used_memory_scripts) {
        this.used_memory_scripts = used_memory_scripts;
    }

    public String getUsed_memory_scripts_human() {
        return used_memory_scripts_human;
    }

    public void setUsed_memory_scripts_human(String used_memory_scripts_human) {
        this.used_memory_scripts_human = used_memory_scripts_human;
    }

    public int getNumber_of_cached_scripts() {
        return number_of_cached_scripts;
    }

    public void setNumber_of_cached_scripts(int number_of_cached_scripts) {
        this.number_of_cached_scripts = number_of_cached_scripts;
    }

    public long getMaxmemory() {
        return maxmemory;
    }

    public void setMaxmemory(long maxmemory) {
        this.maxmemory = maxmemory;
    }

    public String getMaxmemory_human() {
        return maxmemory_human;
    }

    public void setMaxmemory_human(String maxmemory_human) {
        this.maxmemory_human = maxmemory_human;
    }

    public String getMaxmemory_policy() {
        return maxmemory_policy;
    }

    public void setMaxmemory_policy(String maxmemory_policy) {
        this.maxmemory_policy = maxmemory_policy;
    }

    public double getAllocator_frag_ratio() {
        return allocator_frag_ratio;
    }

    public void setAllocator_frag_ratio(double allocator_frag_ratio) {
        this.allocator_frag_ratio = allocator_frag_ratio;
    }

    public long getAllocator_frag_bytes() {
        return allocator_frag_bytes;
    }

    public void setAllocator_frag_bytes(long allocator_frag_bytes) {
        this.allocator_frag_bytes = allocator_frag_bytes;
    }

    public double getAllocator_rss_ratio() {
        return allocator_rss_ratio;
    }

    public void setAllocator_rss_ratio(double allocator_rss_ratio) {
        this.allocator_rss_ratio = allocator_rss_ratio;
    }

    public long getAllocator_rss_bytes() {
        return allocator_rss_bytes;
    }

    public void setAllocator_rss_bytes(long allocator_rss_bytes) {
        this.allocator_rss_bytes = allocator_rss_bytes;
    }

    public double getRss_overhead_ratio() {
        return rss_overhead_ratio;
    }

    public void setRss_overhead_ratio(double rss_overhead_ratio) {
        this.rss_overhead_ratio = rss_overhead_ratio;
    }

    public long getRss_overhead_bytes() {
        return rss_overhead_bytes;
    }

    public void setRss_overhead_bytes(long rss_overhead_bytes) {
        this.rss_overhead_bytes = rss_overhead_bytes;
    }

    public double getMem_fragmentation_ratio() {
        return mem_fragmentation_ratio;
    }

    public void setMem_fragmentation_ratio(double mem_fragmentation_ratio) {
        this.mem_fragmentation_ratio = mem_fragmentation_ratio;
    }

    public long getMem_fragmentation_bytes() {
        return mem_fragmentation_bytes;
    }

    public void setMem_fragmentation_bytes(long mem_fragmentation_bytes) {
        this.mem_fragmentation_bytes = mem_fragmentation_bytes;
    }

    public long getMem_not_counted_for_evict() {
        return mem_not_counted_for_evict;
    }

    public void setMem_not_counted_for_evict(long mem_not_counted_for_evict) {
        this.mem_not_counted_for_evict = mem_not_counted_for_evict;
    }

    public long getMem_replication_backlog() {
        return mem_replication_backlog;
    }

    public void setMem_replication_backlog(long mem_replication_backlog) {
        this.mem_replication_backlog = mem_replication_backlog;
    }

    public int getMem_clients_slaves() {
        return mem_clients_slaves;
    }

    public void setMem_clients_slaves(int mem_clients_slaves) {
        this.mem_clients_slaves = mem_clients_slaves;
    }

    public int getMem_clients_normal() {
        return mem_clients_normal;
    }

    public void setMem_clients_normal(int mem_clients_normal) {
        this.mem_clients_normal = mem_clients_normal;
    }

    public int getMem_aof_buffer() {
        return mem_aof_buffer;
    }

    public void setMem_aof_buffer(int mem_aof_buffer) {
        this.mem_aof_buffer = mem_aof_buffer;
    }

    public String getMem_allocator() {
        return mem_allocator;
    }

    public void setMem_allocator(String mem_allocator) {
        this.mem_allocator = mem_allocator;
    }

    public int getActive_defrag_running() {
        return active_defrag_running;
    }

    public void setActive_defrag_running(int active_defrag_running) {
        this.active_defrag_running = active_defrag_running;
    }

    public int getLazyfree_pending_objects() {
        return lazyfree_pending_objects;
    }

    public void setLazyfree_pending_objects(int lazyfree_pending_objects) {
        this.lazyfree_pending_objects = lazyfree_pending_objects;
    }
}
